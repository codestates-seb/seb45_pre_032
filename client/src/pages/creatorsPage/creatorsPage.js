import './creatorsPage.css';
import Header_Logging from '../../components/Header/Header_Logging/Header_Logging';
import Header_Not_LogIn from '../../components/Header/Header_Not_LogIn/Header_Not_LogIn';
import Creators_Item from "../../components/Creators_Item/Creators_Item";

export default function CreatorsPage () {
  return (
    <>
      {/* <Header_Logging /> */}
      <Header_Not_LogIn />
      <main className='creators_total_container'>
        <article className='creators_section_container'>
              <section className='creators_FE_container'>
                  <h1 className='creators_field'>Front-End</h1>
                  <div className='creators_list_container'>
                    <Creators_Item />
                    <Creators_Item />
                    <Creators_Item />
                  </div>
              </section>
        </article>
        <article className='creators_section_container'>
              <section>
                  <h1 className='creators_field'>Back-End</h1>
                  <div className='creators_list_container'>
                    <Creators_Item />
                    <Creators_Item />
                    <Creators_Item />
                    <Creators_Item />
                  </div>
              </section>
        </article>
      </main>
    </>
  );
}