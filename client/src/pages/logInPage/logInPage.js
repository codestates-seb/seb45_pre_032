import './logInPage.css';
import Header_Not_LogIn from '../../components/Header/Header_Not_LogIn/Header_Not_LogIn';
import LogIn from '../../components/LogIn/LogIn';

export default function LogInPage () {
  return (
    <>
      <Header_Not_LogIn />
      <main className='logInPage_main_total'>
        <form className='logInPage_Log_in_form'>
          <LogIn />
        </form>
      </main>
    </>
  );
}