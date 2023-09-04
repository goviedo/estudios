import { auth } from "@clerk/nextjs";
import { NextResponse } from "next/server";
import { OpenAI } from "openai";


const openai = new OpenAI({
    apiKey: process.env.OPENAI_API_KEY
});

export async function POST(
    req: Request
) {
    try {
        const { userId } = auth();
        const body = await req.json();
        const { messages } = body;

        if(!userId) {
            return new NextResponse("No esta autorizado", { status: 401 });
        }

        if(!messages) {
            return new NextResponse("Falta tu pregunta", { status: 400 });
        }

        const streamChatCompletion = await openai.chat.completions.create({
            model: "gpt-3.5-turbo",
            messages,
            stream: false
        })


        //for await (const part of stramChatCompletion) {
        //    return NextResponse.json(part.choices[0].delta);
        //}
        return NextResponse.json(streamChatCompletion);
    } catch(error) {
        console.log("[CONVERSATION_ERROR]", error);
        return new NextResponse("Error en la api OpenAI", { status: 500 });
    }
}