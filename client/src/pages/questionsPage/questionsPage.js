import './questionsPage.css';

import Header_Logging from '../../components/Header/Header_Logging/Header_Logging';
import Header_Not_LogIn from '../../components/Header/Header_Not_LogIn/Header_Not_LogIn';
import Nav from '../../components/Nav/Nav';
import SideBar from '../../components/SideBar/SideBar';

export default function QuestionsPage () {
    return (
        <>
            {/* <Header_Logging /> */}
            <Header_Not_LogIn />
            <div className='questionsPage_main_section_division'>
                <Nav/>
                <main className='questionsPage_main_container'>
                    <div className='questionsPage_title_container'>
                        <h1>All questions</h1>
                    </div>
                </main>
                <SideBar />
            </div>
        </>
    )
}