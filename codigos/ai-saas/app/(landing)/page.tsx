import { Button } from '@/components/ui/button'
import Image from 'next/image'
import Link from 'next/link'

export default function Home() {
  return (
    <>
      Pagina de entrada (No Protegida)
      <div>
        <Link href="/sign-in">
          <Button>
            Entrar
          </Button>
        </Link>
        <Link href="/sign-up">
          <Button>
            Registrarse
          </Button>
        </Link>
      </div>
    </>
  )
}
