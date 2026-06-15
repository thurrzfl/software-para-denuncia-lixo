//criado por arthur
//data 07/06/2026
import { useState } from 'react'

function RegisterPage() {
    const [nome, setNome] = useState('')
    const [email, setEmail] = useState('')
    const [senha, setSenha] = useState('')
    const [erro, setErro] = useState('')

    async function handleCadastro() {
        try {
            const response = await fetch('http://localhost:8080/usuarios', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ nome, email, senha })
            })

            if (!response.ok) {
                const msg = await response.text()
                throw new Error(msg)
            }

            alert('Cadastro realizado com sucesso!')
        } catch (e) {
            setErro(e.message)
        }
    }

    return (
        <div>
            <h1>Cadastro</h1>
            <input
                type="text"
                placeholder="Nome"
                value={nome}
                onChange={(e) => setNome(e.target.value)}
            />
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
            <button onClick={handleCadastro}>Cadastrar</button>
            {erro && <p>{erro}</p>}
        </div>
    )
}

export default RegisterPage