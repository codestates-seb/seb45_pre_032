import './LogOut.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faStackOverflow } from '@fortawesome/free-brands-svg-icons'

import { Link } from 'react-router-dom';

export default function LogOut () {
    return (
        <div className='log_out_form_input_total'>
            <Link to='/'>
                <div className='log_out_form_logo_container'>
                    <FontAwesomeIcon icon={faStackOverflow} className='log_out_form_logo_icon'/>
                    <div className='log_out_form_link_stackoverflow'>stackoverflow.com</div>
                </div>
            </Link>
            <div className='log_out_form_btn_container'>
                <button className='log_out_form_log_out_btn'>Log out</button>
                <button className='log_out_form_cancel_btn'>Cancel</button>
            </div>
            <div className='log_out_form_last_text'>If you're on a shared computer, remember to log out of your Open ID provider (Facebook, Google, Stack Exchange, etc.) as well.</div>
        </div>
    )
}