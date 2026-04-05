import {BrowserRouter, Route, Routes} from "react-router-dom"
import DashBoard from './pages/Dashboard/Dashboard'


function App() {

  return (
   <BrowserRouter>
   <Routes>
   <Route path='/dashboard' element={<DashBoard />}></Route>
    {/* <Route path="/proveedor/:id" element={<DetalleProveedor />} /> */}
   </Routes>
   </BrowserRouter>
  )
 

}

export default App
