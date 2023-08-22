import './signUpPage.css';

import Header_Logging from '../../components/Header/Header_Logging/Header_Logging';
import Header_Not_LogIn from '../../components/Header/Header_Not_LogIn/Header_Not_LogIn';
import SignUp from '../../components/SignUp/SignUp';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faCircleQuestion } from '@fortawesome/free-solid-svg-icons';
import { faSort } from '@fortawesome/free-solid-svg-icons';
import { faBookmark } from '@fortawesome/free-solid-svg-icons';
import { faTrophy } from '@fortawesome/free-solid-svg-icons';

export default function SignUpPage () {
  return (
    <>
      <Header_Not_LogIn />
      <main className='signUpPage_main_total'>
        <form className='signUpPage_sign_up_sections'>
          <section className='signUpPage_text_containers'>
            <h1 className='signUpPage_text_h1'>
              Join the Stack Overflow community
            </h1>
            <div className='signUpPage_text_container'>
              <div className='signUpPage_text_circleQuestion_icon'>
                <FontAwesomeIcon icon={faCircleQuestion} />
              </div>
              <div className='signUpPage_texts'>
                Get unstuck -- ask a question
              </div>
            </div>
            <div className='signUpPage_text_container'>
              <div className='signUpPage_text_sort_icon'>
                <FontAwesomeIcon icon={faSort} />
              </div>
              <div className='signUpPage_texts'>
                Unlock new privileges like voting and commenting
              </div>
            </div>
            <div className='signUpPage_text_container'>
              <div className='signUpPage_text_bookmark_icon'>
                <FontAwesomeIcon icon={faBookmark} />
              </div>
              <div className='signUpPage_texts'>
                Save your favorite questions, answers, watch tags, and more
              </div>
            </div>
            <div className='signUpPage_text_container'>
              <div className='signUpPage_text_trophy_icon'>
                <FontAwesomeIcon icon={faTrophy} />
              </div>
              <div className='signUpPage_texts'>
                Earn reputation and badges
              </div>
            </div>
            <div>
              <div className='signUpPage_gray_text'>
                Collaborate and share knowledge with a private group for FREE
              </div>
              <div className='signUpPage_blue_text'>
                Get Stack Overflow for Teams free for up to 50 users.
              </div>
            </div>
          </section>
          <section className='signUpPage_sign_up_form'>
            <SignUp/>
          </section>
        </form>
      </main>
    </>
  );
}