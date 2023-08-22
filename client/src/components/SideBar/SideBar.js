import './SideBar.css';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faStackOverflow } from '@fortawesome/free-brands-svg-icons'
import { faPen } from '@fortawesome/free-solid-svg-icons'
import { faMessage } from '@fortawesome/free-regular-svg-icons'

export default function SideBar () {
    return (
        <div className='sideBar_total_container'>
            <section className=''>
                <div className='sideBar_title'>The Overflow Blog</div>
                <div className='sideBar_content_container'>
                    <div className='sideBar_content'>
                        <FontAwesomeIcon icon={faPen} />
                        <div>Semantic search without the napalm Grandma exploit (Ep. 600)</div>
                    </div>
                </div>
            </section>
            <section>
                <div className='sideBar_title'>Featured on Meta</div>
                <div className='sideBar_content_container'>
                    <div className='sideBar_content'>
                        <FontAwesomeIcon icon={faMessage} />
                        <div>Moderation strike: Results of negotiations</div>
                    </div>
                    <div className='sideBar_content'>
                        <FontAwesomeIcon icon={faMessage} />
                        <div>Our Design Vision for Stack Overflow and the Stack Exchange network</div>
                    </div>
                    <div className='sideBar_content'>
                        <FontAwesomeIcon icon={faStackOverflow} />
                        <div>Temporary policy: Generative AI (e.g., ChatGPT) is banned</div>
                    </div>
                    <div className='sideBar_content'>
                        <FontAwesomeIcon icon={faStackOverflow} />
                        <div>Collections: A New Feature for Collectives on Stack Overflow</div>
                    </div>
                    <div className='sideBar_content'>
                        <FontAwesomeIcon icon={faStackOverflow} />
                        <div>Call for volunteer reviewers for an updated search exprience: OverflowAI Search</div>
                    </div>
                </div>
            </section>
            <section>
            <div className='sideBar_title'>Hot Meta Posts</div>
            <div className='sideBar_content_container'>
                <div className='sideBar_content'>
                    <div>26</div>
                    <div>How to handle user that sabotaged dozens of their old questions and answers...</div>
                </div>
            </div>
            </section>
        </div>
    )
}