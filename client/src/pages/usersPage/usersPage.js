import './usersPage.css';

import Header_Logging from '../../components/Header/Header_Logging/Header_Logging';
import Header_Not_LogIn from '../../components/Header/Header_Not_LogIn/Header_Not_LogIn';
import Nav from '../../components/Nav/Nav';

export default function UsersPage () {
    return (
        <>
            {/* <Header_Logging /> */}
            <Header_Not_LogIn />
            <div className='usersPage_main_section_division'>
                <Nav/>
                <main className='usersPage_main_container'>
                    <div className='usersPage_title_container'>
                        <h1>Users</h1>
                    </div>
                </main>
            </div>
        </>
    )
}