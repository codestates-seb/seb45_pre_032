import './App.css';

import { BrowserRouter, Routes, Route } from 'react-router-dom'
import HomePage from './pages/homePage/homePage';
import QuestionsPage from './pages/questionsPage/questionsPage';
import CreatorsPage from './pages/creatorsPage/creatorsPage';
import SignUpPage from './pages/signUpPage/signUpPage';
import LogInPage from './pages/logInPage/logInPage';
import LogOutPage from './pages/logOutPage/logOutPage';

import TagsPage from './pages/tagsPage/tagsPage';
import UsersPage from './pages/usersPage/usersPage';
import CompaniesPage from './pages/companiesPage/companiesPage';

import AskPage from './pages/askPage/askPage';
import HelpPage from './pages/helpPage/helpPage';

export default function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route path='/' element={<HomePage />}/>
          <Route path='/questions' element={<QuestionsPage />}/>
          <Route path='/tags' element={<TagsPage />}/>
          <Route path='/users' element={<UsersPage />}/>
          <Route path='/companies' element={<CompaniesPage />}/>

          <Route path='/creators' element={<CreatorsPage />}/>
          <Route path='/members/login' element={<LogInPage />}/>
          <Route path='/members/logout' element={<LogOutPage />}/>
          <Route path='/members/signup' element={<SignUpPage />}/>

          <Route path='/questions/ask' element={<AskPage />}/>
          <Route path='/help/searching' element={<HelpPage />}/>
          
        </Routes>
      </div>
    </BrowserRouter>
  );
}