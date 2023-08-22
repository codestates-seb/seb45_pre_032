import './Nav.css';
import { useState } from 'react';
import { Link } from 'react-router-dom';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faEarthAmericas } from '@fortawesome/free-solid-svg-icons'

export default function Nav () {
    // Nav list active 정의
    const [activeIndex, setActiveIndex] = useState(null);

    // Nav list active handler
    const handleItemClick = (index) => {
        setActiveIndex(index);
    };

    return (
        <nav className='nav_total_container'>
            <ul className='nav_ul'>
                <Link to='/'>
                    <li className={`nav_home ${activeIndex === 0 ? 'active' : ''}`}
                    onClick={() => handleItemClick(0)}>
                        Home
                    </li>
                </Link>
            </ul>
            <ul className='nav_ul'>
                <li className='nav_text_public'>PUBLIC</li>
                <Link to='/questions'>
                    <li className={`nav_questions ${activeIndex === 1 ? 'active' : ''}`}
                        onClick={() => handleItemClick(1)}>
                        <FontAwesomeIcon icon={faEarthAmericas} className='nav_questions_icon'/>
                        <span>Questions</span>
                    </li>
                </Link>
                <Link to='/tags'>
                    <li className={`nav_li ${activeIndex === 2 ? 'active' : ''}`}
                        onClick={() => handleItemClick(2)}>
                        Tags
                    </li>
                </Link>
                <Link to='/users'>
                    <li className={`nav_li ${activeIndex === 3 ? 'active' : ''}`}
                        onClick={() => handleItemClick(3)}>
                        Users
                    </li>
                </Link>
                <Link to='/companies'>
                    <li className={`nav_li ${activeIndex === 4 ? 'active' : ''}`}
                        onClick={() => handleItemClick(4)}>
                        Companies
                    </li>
                </Link>
            </ul>
        </nav>
    )
}