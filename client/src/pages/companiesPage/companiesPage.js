import './companiesPage.css';

import Header_Logging from '../../components/Header/Header_Logging/Header_Logging';
import Header_Not_LogIn from '../../components/Header/Header_Not_LogIn/Header_Not_LogIn';
import Nav from '../../components/Nav/Nav';

export default function CompaniesPage () {
    return (
        <>
            {/* <Header_Logging /> */}
            <Header_Not_LogIn />
            <div className='companiesPage_main_section_division'>
                <Nav/>
                <main className='companiesPage_main_container'>
                    <div className='companiesPage_title_container'>
                        <h1>Companies</h1>
                    </div>
                </main>
            </div>
        </>
    )
}