import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Calculadora from './components/calculadora'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Calculadora>
        
      </Calculadora>
    </>
  )
}

export default App
