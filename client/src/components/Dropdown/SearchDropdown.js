import { Link } from 'react-router-dom'
import './SearchDropdown.css'

export default function SearchDropdown () {
    return (
        <article className='searchDropdown_total_container'>
            <section className='searchDropdown_text_total_container'>
                <div className='searchDropdown_text_containers'>
                    <div className='searchDropdown_text_container'>
                        <span className='searchDropdown_left_text'>[tag]</span>
                        <span className='searchDropdown_right_text'>search within a tag</span>
                    </div>
                    <div className='searchDropdown_text_container'>
                        <span className='searchDropdown_left_text'>user:1234</span>
                        <span className='searchDropdown_right_text'>search by author</span>
                    </div>
                    <div className='searchDropdown_text_container'>
                        <span className='searchDropdown_left_text'>"words here"</span>
                        <span className='searchDropdown_right_text'>exact phrase</span>
                    </div>
                    <div className='searchDropdown_text_container'>
                        <span className='searchDropdown_left_text'>collective:"Name"</span>
                        <span className='searchDropdown_right_text'>collective content</span>
                    </div>
                </div>
                <div className='searchDropdown_text_containers'>
                    <div className='searchDropdown_text_container'>
                        <span className='searchDropdown_left_text'>answers:0</span>
                        <span className='searchDropdown_right_text'>unanswered questions</span>
                    </div>
                    <div className='searchDropdown_text_container'>
                        <span className='searchDropdown_left_text'>score:3</span>
                        <span className='searchDropdown_right_text'>posts with a 3+ score</span>
                    </div>
                    <div className='searchDropdown_text_container'>
                        <span className='searchDropdown_left_text'>is:question</span>
                        <span className='searchDropdown_right_text'>type of post</span>
                    </div>
                    <div className='searchDropdown_text_container'>
                        <span className='searchDropdown_left_text'>isaccepted:yes</span>
                        <span className='searchDropdown_right_text'>search within status</span>
                    </div>
                </div>
            </section>
            <section className='searchDropdown_link_container'>
                <Link to='/questions/ask'>
                    <button className='searchDropdown_link'>Ask a question</button>
                </Link>
                <Link to='/help/searching'>
                    <div className='searchDropdown_help_link'>Search help</div>
                </Link>
            </section>
        </article>
    )
}