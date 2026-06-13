//criado por arthur
//data 07/06/2026

//antigo arquivo apagado e dando início ao nobo
//13/06/2026



import { useState } from 'react'
import { login } from '../services/authService'
import Header from '../components/Header'

function LoginPage() {
    const [email, setEmail] = useState('')
    const [senha, setSenha] = useState('')
    const [erro, setErro] = useState('')

    async function handleLogin() {
        try {
            const usuario = await login(email, senha)
            alert('Bem-vindo, ' + usuario.nome + '!')
        } catch (e) {
            setErro(e.message)
        }
    }

    return (
        <div>
            <Header />
            <h1>Conecte-se</h1>
            <input
                type="email"
                placeholder="E-mail"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
            />
            <input
                type="password"
                placeholder="Senha"
                value={senha}
                onChange={(e) => setSenha(e.target.value)}
            />
            <button onClick={handleLogin}>Entrar</button>
            {erro && <p>{erro}</p>}
        </div>
    )
}

export default LoginPage