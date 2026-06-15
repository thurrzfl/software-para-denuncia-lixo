//criado por arthur
//data 07/06/2026
import { useState } from 'react'

function NovaDenunciaPage() {
    const [descricao, setDescricao] = useState('')
    const [foto, setFoto] = useState('')
    const [localizacao, setLocalizacao] = useState('')
    const [erro, setErro] = useState('')

    async function handleCriarDenuncia() {
        try {
            const response = await fetch('http://localhost:8080/denuncias', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ descricao, foto, localizacao })
            })

            if (!response.ok) {
                const msg = await response.text()
                throw new Error(msg)
            }

            alert('Denúncia criada com sucesso!')
        } catch (e) {
            setErro(e.message)
        }
    }

    return (
        <div>
            <h1>Nova Denúncia</h1>
            <input
                type="text"
                placeholder="Descrição"
                value={descricao}
                onChange={(e) => setDescricao(e.target.value)}
            />
            <input
                type="text"
                placeholder="Foto (URL)"
                value={foto}
                onChange={(e) => setFoto(e.target.value)}
            />
            <input
                type="text"
                placeholder="Localização"
                value={localizacao}
                onChange={(e) => setLocalizacao(e.target.value)}
            />
            <button onClick={handleCriarDenuncia}>Enviar Denúncia</button>
            {erro && <p>{erro}</p>}
        </div>
    )
}

export default NovaDenunciaPage