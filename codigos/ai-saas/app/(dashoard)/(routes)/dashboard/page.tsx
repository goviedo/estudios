"use client";

import { useRouter } from "next/navigation";
import { Card } from "@/components/ui/card";
import { cn } from "@/lib/utils";
import { ArrowRight, Code2Icon, ImageIcon, MessageSquare, Music, Settings2Icon, VideoIcon } from "lucide-react";


const tools = [
    {
        label: "Conversacion",
        icon: MessageSquare,
        color: "text-violet-500",
        bgColor: "bg-violet-500/10",
        href: "/conversation"
    },
    {
        label: "Generacion de Imagenes",
        icon: ImageIcon,
        color: "text-pink-700",
        bgColor: "bg-pink-500/10",
        href: "/image"
    },
    {
        label: "Generacion de Videos",
        icon: VideoIcon, 
        color: "text-yellow-700",
        bgColor: "bg-yellow-500/10",
        href: "/video"
    },
    {
        label: "Generacion de Codigo",
        icon: Code2Icon,
        color: "text-violet-700",
        bgColor: "bg-violet-500/10",
        href: "/code"
    },
    {
        label: "Configuracion",
        icon: Settings2Icon,
        href: "/settings",
    }
]

const DashboardPage = () => {

    const router = useRouter()

    return (
        <>
            <div className="mb-4">
                <h2 className="text-2xl md:text-4xl font-bold text-center">
                    El poder de la Inteligencia Artificial
                </h2>
                <p className="text-muted-foreground font-light text-sm md:text-lg text-center">
                    Conversaciones / Chat con la IA mas inteligente
                </p>
            </div>
            <div className="px-4 px-4 md:px-20 lg:px-32 space-y-4">
                { tools.map((tool)=>(
                    <Card
                        onClick={()=>router.push(tool.href)}
                        key="{tools.href}"
                        className="p-4 border-black/5 flex items-center justify-between hover:shadow-md transition cursor-pointer"
                    >
                        <div className="flex items-center gap-x-4">
                            <div className={cn("p-2 w-fit rounded-md", tool.bgColor)}>
                                <tool.icon className={cn("", tool.color)}/>
                            </div>
                            <div className="font-semibol">
                                {tool.label}
                            </div>
                        </div>
                    <ArrowRight className="w-5 h-5"/>
                    </Card>
                ))}
            </div>
            
        </>
    )
}

export default DashboardPage;