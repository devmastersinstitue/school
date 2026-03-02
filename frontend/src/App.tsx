import { Navigate, Route, Routes } from 'react-router-dom'
import './App.css'
import SignupPage from './pages/SignupPage'

export default function App() {
  return (
    <div className="appRoot">
      <Routes>
        <Route path="/" element={<Navigate to="/signup" replace />} />
        <Route path="/signup" element={<SignupPage />} />
        <Route path="*" element={<Navigate to="/signup" replace />} />
      </Routes>
    </div>
  )
}
