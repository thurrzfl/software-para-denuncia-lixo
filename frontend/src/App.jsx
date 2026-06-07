// criado por arthur
//data 07/06/2026

import { BrowserRouter, Routes, Route } from 'react-router-dom'
import HomePage from './pages/HomePage'
import LoginPage from './pages/LoginPage'
import RegisterPage from './pages/RegisterPage'
import DenunciasPage from './pages/DenunciasPage'
import NovaDenunciaPage from './pages/NovaDenunciaPage'

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/cadastro" element={<RegisterPage />} />
        <Route path="/denuncias" element={<DenunciasPage />} />
        <Route path="/nova-denuncia" element={<NovaDenunciaPage />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App