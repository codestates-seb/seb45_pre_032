import './Header_Logging.css'

// fontawesome으로 아이콘을 불러온다.
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faStackOverflow } from '@fortawesome/free-brands-svg-icons'
import { faMagnifyingGlass } from '@fortawesome/free-solid-svg-icons'
import { faUser } from '@fortawesome/free-solid-svg-icons'
import { faInbox } from '@fortawesome/free-solid-svg-icons'
import { faTrophy } from '@fortawesome/free-solid-svg-icons'
import { faCircleQuestion } from '@fortawesome/free-solid-svg-icons'
import { faStackExchange } from '@fortawesome/free-brands-svg-icons'

import { Link } from 'react-router-dom';
import { useState, useEffect } from 'react'

import SearchDropdown from '../../Dropdown/SearchDropdown'

export default function Header_Logging () {
    // Search Dropdown state 정의
    const [isSearchDropdownOpen, setIsSearchDropdownOpen] = useState(false)

    // search의 state가 true이면 드롭다운이 나오고, false이면 드롭다운이 사라진다.
    // search 드롭다운을 클릭하면 search 드롭다운이 나오고, 한 번더 search 드롭다운을 클릭하면 search 드롭다운이 꺼지도록 한다. (구현 완료)
    // search 드롭다운이 나온 경우에 search 드롭다운을 제외한 나머지 화면을 클릭하면 search 드롭다운이 꺼지도록 한다. (구현 해야함)
    const searchDropdownHandler = () => {
        setIsSearchDropdownOpen(!isSearchDropdownOpen);
    }

    return (
        <header className='header_logging_container'>
            <Link to='/'>
                <div className='header_logging_logo_container'>
                    <div className='header_logging_logo_img'>
                        <FontAwesomeIcon icon={faStackOverflow} />
                    </div>
                    <div className='header_logging_logo_name'>
                        <span>stack</span>
                        <span className='header_logging_logo_name_overflow'>overflow</span>
                    </div>
                </div>
            </Link>
            <Link to='/creators'>
                <div className='header_logging_creators'>Creators</div>
            </Link>
            <div className="header_logging_search_container" onClick={searchDropdownHandler}>
                <FontAwesomeIcon icon={faMagnifyingGlass} className='header_logging_search_icon' />
                <input type="text" className="header_logging_search_input" placeholder="Search..." />
                {isSearchDropdownOpen ? <SearchDropdown /> : null}
            </div>

            <ul className='header_logging_icons_container'>
                <li className='header_logging_icons_item' target='_blank' title='Member name'>
                    <FontAwesomeIcon icon={faUser}/>
                </li>
                <li className='header_logging_icons_item' target='_blank' title='Recent inbox messages'>
                    <FontAwesomeIcon icon={faInbox} />
                </li>
                <li className='header_logging_icons_item' target='_blank' title='Recent achievements: reputation, badges, and privileges earned'>
                    <FontAwesomeIcon icon={faTrophy} />
                </li>
                <li className='header_logging_icons_item' target='_blank' title='Help center and other resources'>
                    <FontAwesomeIcon icon={faCircleQuestion} />
                </li>
                <li className='header_logging_icons_item' target='_blank' title='A list of all 183 Stack Exchange sites'>
                    <FontAwesomeIcon icon={faStackExchange} />
                </li>
            </ul>
            <Link to='/members/logout'>
                <button className='header_logging_Log_out_btn'>Log Out</button>
            </Link>
        </header>
    )
}
