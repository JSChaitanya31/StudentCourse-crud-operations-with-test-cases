import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import StudentService from '../service/StudentService';


const ViewComponent = () => {

const [studentArray, setStudentArray] = useState([]);

useEffect(()=>{
    getAllStudents();
},[]);


function getAllStudents() {
    StudentService.getAllStudents()
    .then(res=>{setStudentArray(res.data); console.log(res)})
    .catch(e=>console.log(e));
}

function deleteStudent(e, id) {
    e.preventDefault()
    StudentService.deleteStudent(id).then(getAllStudents()).catch(e => console.log(e));
}

  return (
    <div className='container'>
        <Link to={"/add-student"} className='btn btn-primary mb-2 mt-3' href="">Add Student</Link>
        <h2 className='text-center mb-4'>Register List</h2>
        <table className='table table-bordered table striped'>
              <thead>
                  <tr>
                      <th> ID</th>
                      <th>StudentName</th>
                      <th>Student Email</th>
                      <th>Course</th>
                      <th>Actions</th>
                  </tr>
              </thead>
            <tbody>
                  {studentArray.map(student =>
                      <tr id={student.id}>
                          <td>{student.id}</td>
                          <td>{student.studentName}</td>
                          <td>{student.studentEmail}</td>
                          <td>{student.course}</td>
                          <td>
                              <Link to={`/add-student/${student.id}`} className='btn btn-info' href="">Update</Link> {" "}
                              <a onClick={(e) => deleteStudent(e, student.id)} className='btn btn-danger'>Delete</a>
                          </td>
                      </tr>)}

            </tbody>
        </table>
    </div>
  )
}

export default ViewComponent