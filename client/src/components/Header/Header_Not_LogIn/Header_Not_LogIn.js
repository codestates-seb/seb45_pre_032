import './Header_Not_LogIn.css'

// fontawesome으로 아이콘을 불러온다.
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faStackOverflow } from '@fortawesome/free-brands-svg-icons'
import { faMagnifyingGlass } from '@fortawesome/free-solid-svg-icons'

import { Link } from 'react-router-dom';
import { useState, useEffect } from 'react'

import SearchDropdown from '../../Dropdown/SearchDropdown'

export default function Header_Not_LogIn () {
    // Search Dropdown state 정의
    const [isSearchDropdownOpen, setIsSearchDropdownOpen] = useState(false)

    // search의 state가 true이면 드롭다운이 나오고, false이면 드롭다운이 사라진다.
    // search 드롭다운을 클릭하면 search 드롭다운이 나오고, 한 번더 search 드롭다운을 클릭하면 search 드롭다운이 꺼지도록 한다. (구현 완료)
    // search 드롭다운이 나온 경우에 search 드롭다운을 제외한 나머지 화면을 클릭하면 search 드롭다운이 꺼지도록 한다. (구현 해야함)
    const searchDropdownHandler = () => {
        setIsSearchDropdownOpen(!isSearchDropdownOpen);
    }

    return (
        <header className='header_not_log_in_container'>
            <Link to='/'>
                <div className='header_not_log_in_logo_container'>
                    <div className='header_not_log_in_logo_img'>
                        <FontAwesomeIcon icon={faStackOverflow} />
                    </div>
                    <div className='header_not_log_in_logo_name'>
                        <span>stack</span>
                        <span className='header_not_log_in_logo_name_overflow'>overflow</span>
                    </div>
                </div>
            </Link>
            <Link to='/creators'>
                <div className='header_not_log_in_creators'>Creators</div>
            </Link>
            <div className="header_not_log_in_search_container" onClick={searchDropdownHandler}>
                <FontAwesomeIcon icon={faMagnifyingGlass} className='header_not_log_in_search_icon' />
                <input type="text" className="header_not_log_in_search_input" placeholder="Search..." />
                {isSearchDropdownOpen ? <SearchDropdown /> : null}
            </div>
            <Link to='/members/login'>
                <button className='header_not_log_in_log_in_btn'>Log in</button>
            </Link>
            <Link to='/members/signup'>
                <button className='header_not_log_in_sign_up_btn'>Sign up</button>
            </Link>
        </header>
    )
}
