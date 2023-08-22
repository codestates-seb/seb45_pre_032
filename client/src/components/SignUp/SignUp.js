import './SignUp.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faGoogle } from '@fortawesome/free-brands-svg-icons';

import { Link } from 'react-router-dom';

export default function SignUp () {
    return (
        <div className='sign_up_form_total'>
            <div className='social_sign_up_form_container'>
                <button className='social_sign_up_form_google'><FontAwesomeIcon icon={faGoogle} className='social_sign_up_form_google_icon' />Sign up with Google</button>
            </div>
            <div className='sign_up_form_input_total'>
                <div>
                    <div className='sign_up_form_input_title'>Display name</div>
                    <input type='text' className='sign_up_form_input_box'></input>
                </div>
                <div>
                    <div className='sign_up_form_input_title'>Email</div>
                    <input type='text' className='sign_up_form_input_box'></input>
                </div>
                <div>
                    <div className='sign_up_form_input_title'>Password</div>
                    <input type='text' className='sign_up_form_input_box'></input>
                    <div className='sign_up_form_password_under_text'>Passwords must contain at least eight characters, including at least 1 letter and 1 number.</div>
                </div>
                <button className='sign_up_form_btn'>Sign up</button>
                <div className='sign_up_form_sign_up_understand'>
                    By clicking "Sign up", you agree to our team of service and acknowledge that you have read and understand our privacy policy and code of conduct.
                </div>
            </div>
            <div className='sign_up_form_last_text'>
                Already have an account?
                <Link to='/members/login'>
                    <span className='sign_up_form_text_log_in'>Log in</span>
                </Link>
            </div>
        </div>
    )
}