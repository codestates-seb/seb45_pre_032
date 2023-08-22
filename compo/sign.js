/*import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import './sign.css';

function Signup() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [nameword, setnameword] = useState('');
  const navigate = useNavigate();

  const handleSignup = () => {
    // 로컬 스토리지에 회원 정보 저장
    localStorage.setItem('user', JSON.stringify({ username, password }));
    // 회원가입 후 로그인 페이지로 이동
    navigate('/');
  };

  return (
    <div className="form-container">
      <h2>회원가입</h2>
      <input type="name" placeholder="닉네임" value={nameword} onChange={(e) => setnameword(e.target.value)} />
      <input type="text" placeholder="사용자 이름" value={username} onChange={(e) => setUsername(e.target.value)} />
      <input type="password" placeholder="비밀번호" value={password} onChange={(e) => setPassword(e.target.value)} />
      <button onClick={handleSignup}>가입하기</button>
      <p>이미 계정이 있으신가요? <Link to="/">로그인</Link></p>
    </div>
  );
}

export default Signup;
*/


import React, { useState } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';
import './sign.css';

function Signup() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [displayName, setDisplayName] = useState('');
  const navigate = useNavigate();

  const handleSignup = async () => {
    try {
      const response = await axios.post('http://example.com/members/signup', {
        email,
        password,
        display_name: displayName,
      });

      // 회원가입 성공 시 처리
      console.log('회원가입 성공:', response.data);
      // 로그인 페이지로 이동
      navigate('/');
    } catch (error) {
      // 회원가입 실패 시 처리
      console.error('회원가입 실패:', error);
      if (error.response && error.response.status === 409) {
        console.log('이미 중복된 사용자입니다.');
      }
    }
  };

  return (
    <div className="form-container">
      <h2>회원가입</h2>
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
      <input
        type="text"
        placeholder="이름"
        value={displayName}
        onChange={(e) => setDisplayName(e.target.value)}
      />
      <button onClick={handleSignup}>회원가입</button>
      <p>이미 계정이 있으신가요? <Link to="/">로그인</Link></p>
    </div>
  );
}

export default Signup;
