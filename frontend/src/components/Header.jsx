import { Link } from 'react-router-dom'

function Header() {
    return (
        <header>
            <h1>Denuncia Lixo</h1>
            <nav>
                <Link to="/">Início</Link>
                <Link to="/denuncias">Denúncias</Link>
                <Link to="/nova-denuncia">Nova Denúncia</Link>
                <Link to="/login">Login</Link>
            </nav>
        </header>
    )
}

export default Header