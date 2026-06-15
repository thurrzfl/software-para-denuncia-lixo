//criado por arthur
//data 07/06/2026
import { useState, useEffect } from 'react'

function DenunciasPage() {
    const [denuncias, setDenuncias] = useState([])
    const [erro, setErro] = useState('')

    useEffect(() => {
        fetch('http://localhost:8080/denuncias')
            .then(res => res.json())
            .then(data => setDenuncias(data))
            .catch(() => setErro('Erro ao carregar denúncias'))
    }, [])

    return (
        <div>
            <h1>Denúncias</h1>
            {erro && <p>{erro}</p>}
            {denuncias.map(denuncia => (
                <div key={denuncia.id}>
                    <h3>{denuncia.descricao}</h3>
                    <p>Status: {denuncia.status}</p>
                </div>
            ))}
        </div>
    )
}

export default DenunciasPage