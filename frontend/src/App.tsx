import { Navigate, Route, Routes } from "react-router-dom"
import "./App.css"
import SignupPage from "./pages/SignupPage"
import Student from "./Functions/student"
import Teacher from "./Functions/teacher"
import Book from "./Functions/book"
import Parent from "./Functions/parent"
import Class from "./Functions/class"
export default function App() {
  return (
    <div className="appRoot">
      <Routes>
        <Route path="/" element={<Navigate to="/signup" replace />} />
        <Route path="/signup" element={<SignupPage />} />
        <Route path="/Student" element={<Student name="John Doe" age={20} grade="A" rollNumber="23" email="johndoe@example.com" parentName="Jane Doe" address="123 Main Street, Cityville" />} />
        <Route path="*" element={<Navigate to="/signup" replace />} />
        <Route path="/Parent" element={<Parent name="Janny Doe" age={42} email="janny.doe@example.com" phone="+1234567890" address="456 Elm Street, Cityville" occupation="Teacher" childrenCount={2} childrenNames={['John Doe','Alice Doe']} />} />
        <Route path="/Class" element={<Class className="Math 101" totalStudents={25} />} />
        <Route path="/teacher" element={<Teacher name="Jane Smith" subject="Mathematics" experience={10} email="jane.smith@school.com" phone="03001234567" qualification="MSc Mathematics" />} />
        <Route path="/book" element={<Book title="Principles of Economics" author="Gregory Mankiw" category="Economics" year={2020} copies={5} />} />
      </Routes>
    </div>
  )
}