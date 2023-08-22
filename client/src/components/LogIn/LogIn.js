import './LogIn.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faStackOverflow } from '@fortawesome/free-brands-svg-icons'
import { faGoogle } from '@fortawesome/free-brands-svg-icons';

import { Link } from 'react-router-dom';

export default function LogIn () {
    return (
        <div className='log_in_form_total'>
            <div className='log_in_form_logo_container'>
                <Link to='/'>
                    <FontAwesomeIcon icon={faStackOverflow} className='log_in_form_logo_icon'/>
                </Link>
            </div>
            <div className='social_log_in_form_container'>
                <button className='social_log_in_form_google'><FontAwesomeIcon icon={faGoogle} className='social_log_in_form_google_icon' />Log in with Google</button>
            </div>
            <div className='log_in_form_input_total'>
                <div>
                    <div className='log_in_form_input_title'>Email</div>
                    <input type='text' className='log_in_form_input_box'></input>
                </div>
                <div>
                    <div className='log_in_form_password_text_container'>
                        <div className='log_in_form_input_title'>Password</div>
                        <div className='log_in_form_text_forgot'>Forgot password?</div>
                    </div>
                    <input type='text' className='log_in_form_input_box'></input>
                </div>
                <button className='log_in_form_btn'>Log in</button>
            </div>
            <div className='log_in_form_last_text'>
                Don't have an account?
                <Link to='/members/signup'>
                    <span className='log_in_form_text_sign_up'>Sign up</span>
                </Link>
            </div>
        </div>
    )
}