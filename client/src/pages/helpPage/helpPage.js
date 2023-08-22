import './helpPage.css';

import Header_Logging from '../../components/Header/Header_Logging/Header_Logging';
import Header_Not_LogIn from '../../components/Header/Header_Not_LogIn/Header_Not_LogIn';
import Nav from '../../components/Nav/Nav';
import SideBar from '../../components/SideBar/SideBar';

export default function HelpPage () {
    return (
        <>
            {/* <Header_Logging /> */}
            <Header_Not_LogIn />
            <div className='helpPage_main_section_division'>
                <Nav/>
                <main className='helpPage_main_container'>
                    <div className='helpPage_title_container'>
                        <h1>How do I search?</h1>
                    </div>
                </main>
                <SideBar />
            </div>
        </>
    )
}