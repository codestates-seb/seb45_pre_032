import './tagsPage.css';

import Header_Logging from '../../components/Header/Header_Logging/Header_Logging';
import Header_Not_LogIn from '../../components/Header/Header_Not_LogIn/Header_Not_LogIn';
import Nav from '../../components/Nav/Nav';

export default function TagsPage () {
    return (
        <>
            {/* <Header_Logging /> */}
            <Header_Not_LogIn />
            <div className='tagsPage_main_section_division'>
                <Nav/>
                <main className='tagsPage_main_container'>
                    <div className='tagsPage_title_container'>
                        <h1>Tags</h1>
                    </div>
                </main>
            </div>
        </>
    )
}