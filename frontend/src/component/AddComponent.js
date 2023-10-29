import React from 'react'
import { useState, useEffect } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom';
import StudentService from '../service/StudentService';

const AddComponent = () => {

    const [studentName, setStudentName] = useState('');
    const [studentEmail, setStudentEmail] = useState('');
    const [course, setCourse] = useState('');
    const navigate = useNavigate();
    const { id } = useParams();

    const studentData = { studentName, studentEmail, course };

    function saveStudent(e) {
        e.preventDefault();

        if (studentData.studentName !== "" && studentData.studentEmail !== "" && studentData.course != "") {
            /**If id is present in the parameter, it should update else it should save */
            if (id) {
                StudentService.updateStudent(id, studentData)
                    .then(navigate("/registrations"))
                    .catch(e => console.log(e));
            } else {
                StudentService.saveStudent(studentData)
                    .then(navigate("/registrations"))
                    .catch(e => console.log(e));
            }

        } else {
            alert("Please, fill in all inputes");
        }
    }

    function tile() {
        if (id) {
            return "Update Details";
        } else {
            return "Add Details";
        }
    }

    useEffect(() => {
        if (id) {
            StudentService.getStudentById(id)
                .then(res => {
                    setStudentName(res.data.studentName);
                    setStudentEmail(res.data.studentEmail);
                    setCourse(res.data.course);
                })
                .catch(e => console.log(e));
        }
    }, []);


  return (
    <div>
        <div className='container mt-5'>
            <div className='row'>
                <div className='card col-md-6 offset-md-3'>
                    <h2 className='text-center'>{tile()}</h2>
                    <div className='card-body'>
                        <form>
                            <div className='form-group mb-2'>
                                <input className='form-control' 
                                value={studentName}
                                onChange={(e) => setStudentName(e.target.value)}
                                type="text" placeholder='Enter Name' />
                            </div>
                            <div className='form-group mb-2'>
                                <input className='form-control' 
                                value={studentEmail}
                                onChange={(e) => setStudentEmail(e.target.value)}
                                type="email" placeholder='Enter Email' />
                            </div>
                            <div className='form-group mb-2'>
                                <input className='form-control' 
                                value={course}
                                onChange={(e) => setCourse(e.target.value)}
                                type="text" placeholder='Enter Course' />
                            </div>
                            <button onClick={(e) => saveStudent(e)} className='btn btn-success'>Save</button> {" "}
                            <Link to={"/registrations"}  className='btn btn-danger' href="">Cancel</Link>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
  )
}

export default AddComponent