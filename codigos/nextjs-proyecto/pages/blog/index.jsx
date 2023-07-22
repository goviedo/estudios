import Image from "next/image";
import Link from "next/link";
import Head from "next/head"

 export default function index() {
    return (
        <div>
            <Head>
            <title>Mi primer post con nextjs</title>
            <meta
                name="description"
                content="Posts de Gonzalo Oviedo"
            />
            </Head>
            <h1>Mis Posts</h1>
            <Image
                src="/imgs/1.jpg"
                width={600}
                height={600}
                alt="Mi imagen sacadca de Picsun"
            ></Image>
            <br />
            <Link href="/">
                <a>Volver al Inicio</a>
            </Link>
            <br />
        </div>
    )
 }
 