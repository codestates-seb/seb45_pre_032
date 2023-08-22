import './askPage.css';

import Header_Logging from '../../components/Header/Header_Logging/Header_Logging';
import Header_Not_LogIn from '../../components/Header/Header_Not_LogIn/Header_Not_LogIn';
import SideBar from '../../components/SideBar/SideBar';

export default function AskPage () {
    return (
        <>
            {/* <Header_Logging /> */}
            <Header_Not_LogIn />
            <div className='askPage_main_section_division'>
                <main className='askPage_main_container'>
                    <div className='askPage_title_container'>
                        <h1>Ask a public question</h1>
                    </div>
                </main>
                <SideBar />
            </div>
        </>
    )
}