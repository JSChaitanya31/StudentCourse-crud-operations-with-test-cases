import React from 'react'

const FooterComponent = () => {
    return (
        <div>
            <footer className='footer'>
                <span>CRUD Operations Appliication &copy; {new Date().getFullYear()}</span>
            </footer>
        </div>
    )
}

export default FooterComponent