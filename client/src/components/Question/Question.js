import './Question.css';

export default function Question () {
    return (
        <main className='question_total_container'>
            <div className='question_left_containers'>
                <div className='question_left_container'>
                    <span>0</span>
                    <span>vote</span>
                </div>
                <div className='question_left_container'>
                    <span>0</span>
                    <span>answers</span>
                </div>
                <div className='question_left_container'>
                    <span>0</span>
                    <span>views</span>
                </div>
            </div>
            <div className='question_right_container'>
                <h3 className='question_title'><a href='http://www.naver.com'>example question (누르면 네이버로 감)</a></h3>
                <div className='question_member'>😄 member_id 31 asked 1 min ago</div>
            </div>
        </main>
    )
}