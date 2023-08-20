"use client";

import { cn } from "@/lib/utils";
import { Code2Icon, ImageIcon, LayoutDashboard, MessageSquare, Settings2Icon, VideoIcon } from "lucide-react";
import { Montserrat } from "next/font/google";
import Image from "next/image";
import Link from "next/link";
import { usePathname } from 'next/navigation';

const monserrat = Montserrat({
    weight: "600",
    subsets: ["latin"]
});

const routes = [
    {
        label: "Dashboard",
        icon: LayoutDashboard,
        href: "/dashboard",
        color: "text-sky-500"
    },
    {
        label: "Conversacion",
        icon: MessageSquare,
        href: "/conversation",
        color: "text-violet-500"
    },
    {
        label: "Generacion de Imagenes",
        icon: ImageIcon,
        href: "/image",
        color: "text-pink-700"
    },
    {
        label: "Generacion de Videos",
        icon: VideoIcon,
        href: "/video",
        color: "text-yellow-700"
    },
    {
        label: "Generacion de Codigo",
        icon: Code2Icon,
        href: "/code",
        color: "text-green-700"
    },
    {
        label: "Configuracion",
        icon: Settings2Icon,
        href: "/settings",
    }
]

const Sidebar = () => {

    const pathname = usePathname();

    return (
        <div className="space-y-4 py-4 flex flex-col h-full">
            <div>
                <Link href="/dashboard" className="flex items-center pl-3 mb-14">
                    <div className="relative w-8 h-8 mr-4">
                        <Image
                            fill
                            alt="Logo"
                            src="/logo.png"
                        />
                    </div>
                    <h1 className={cn("text-2xl font-bold", monserrat.className)}>
                        Sabio
                    </h1>
                </Link>
                <div className="space-y-1">
                    {routes.map((route)=>(
                        <Link
                            href={route.href}
                            key={route.href}
                            className={cn("text-sm group flex p-3 w-full justify-start font-medium cursor-pointer hover:text-yellow hover:bg-yellow/10 rounded-lg transition",
                            pathname === route.href ? "text-yellow bg-blue" : "text-zinc-400"
                            )}
                        >
                            <div className="flex items-center flex-1">
                                <route.icon className={cn("h-5 w-5 mr-3", route.color)}/>
                                {route.label}
                            </div>
                        </Link>
                    ))}
                </div>
            </div>
        </div>
    )
}

export default Sidebar;