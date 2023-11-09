import AddComponent from "./component/AddComponent";
// import FooterComponent from "./component/FooterComponent";
import HeaderComponent from "./component/HeaderComponent";
import ViewComponent from "./component/ViewComponent";
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <div className="container">
        <HeaderComponent />
        <Routes>
          <Route path="/" element={<ViewComponent />} />
          <Route path="/registrations" element={<ViewComponent />} />
          <Route path="/add-student" element={<AddComponent />} />
          <Route path="/add-student/:id" element={<AddComponent />} />
        </Routes>
        {/* <FooterComponent /> */}
      </div>
    </BrowserRouter>

  );
}

export default App;
