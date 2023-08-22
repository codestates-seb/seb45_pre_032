/*import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import './Login.css';

function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = () => {
    // 로컬 스토리지에서 회원 정보 가져오기
    const storedUser = JSON.parse(localStorage.getItem('user'));
    
    // 로그인 처리
    if (storedUser && storedUser.username === username && storedUser.password === password) {
      // 로그인 성공 후 메인 페이지로 이동
      navigate('/main');
    } else {
      alert('로그인 실패');
    }
  };

  return (
    <div className="form-container">
    <h2>로그인</h2>
    <input type="text" placeholder="사용자 이름" value={username} onChange={(e) => setUsername(e.target.value)} />
    <input type="password" placeholder="비밀번호" value={password} onChange={(e) => setPassword(e.target.value)} />
    <button onClick={handleLogin}>로그인</button>
    <p>계정이 없으신가요? <Link to="/signup">회원가입</Link></p>
  </div>
  );
}

export default Login; */

import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';
import './Login.css';

const Login = () => {
  const navigate = useNavigate();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = async () => {
    try {
      const response = await axios.post('/members/login', {
        email,
        password,
      });

      // 로그인 성공 시 처리
      console.log('로그인 성공:', response.data);

      // 여기에 로그인 성공 후의 동작을 추가
      

      navigate('/main'); // 메인 페이지로 이동
    } catch (error) {
      // 로그인 실패 시 처리
      console.error('로그인 실패:', error);

      // 여기에 로그인 실패 시의 동작을 추가
    }
  };

  return (
    <div className="form-container">
      <h1>로그인</h1>
      <input
        type="email"
        placeholder="이메일"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <input
        type="password"
        placeholder="비밀번호"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      <button onClick={handleLogin}>Login</button>
      <p>계정이 없으신가요? <Link to="/signup">회원가입</Link></p>
    </div>
  );
};

export default Login;
