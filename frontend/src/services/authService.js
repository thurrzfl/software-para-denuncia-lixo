//criado por arthur 
//data 13/06/2026

const API_URL = 'http://localhost:8080'

export async function login(email, senha) {
    const response = await fetch(`${API_URL}/usuarios/login`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ email, senha })
    })

    if (!response.ok) {
        throw new Error('Email ou senha incorretos!')
    }

    return response.json()
}