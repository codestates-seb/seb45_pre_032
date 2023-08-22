import './logOutPage.css';

import Header_Logging from '../../components/Header/Header_Logging/Header_Logging';
import LogOut from '../../components/LogOut/LogOut';

export default function LogOutPage () {
  return (
    <>
      <Header_Logging />
      <main className='logOutPage_main_total'>
        <form className='logOutPage_log_in_form'>
          <h2 className='logOutPage_h2'>Click "Log out" will log you out of the following domains on this device:</h2>
          <LogOut />
        </form>
      </main>
    </>
  );
}