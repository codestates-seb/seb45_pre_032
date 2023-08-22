import './Creators_Item.css'

export default function Creators_Item () {
    return (
        <ul className='creator_list_items'>
            <li>
                {/* 데이터 받아서 mapping하면 될 듯, 일단 하드코딩으로 함 */}
                <img src='짱구짤1.png' alt='FE_crew_img' className='creator_images'/>
                <div className='creator_crew_name'>[FE] Crew Name</div>
                <div className='creator_crew_github_container'>
                    <span className='creator_crew_github'>Github</span>
                    <span>Crew ID</span>
                </div>
            </li>
        </ul>
    )
}