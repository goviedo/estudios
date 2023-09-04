"use client";

import axios from "axios";
import * as z from "zod";
import { Heading } from "@/components/heading";
import { MessageSquare } from "lucide-react";
import { useForm } from "react-hook-form";
import { formSchema } from "./constants";
import { Form, FormControl, FormField, FormItem } from "@/components/ui/form";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import { zodResolver } from "@hookform/resolvers/zod";
import { useRouter } from "next/navigation";
import { useState } from "react";
import OpenAI from "openai";
import Empty from "@/components/empty";
import { Loader } from "@/components/loader";

const ConversationPage = () => {

    const router = useRouter();
    const [ messages, setMessages ] = useState<OpenAI.Chat.CreateChatCompletionRequestMessage[]>([]);
    const [ respuesta, setRespuesta] = useState("");

    const form = useForm<z.infer<typeof formSchema>>({
        resolver: zodResolver(formSchema),
        defaultValues: {
            prompt: ""
        }
    });

    const isLoading = form.formState.isSubmitting;

    const onSubmit = async(values: z.infer<typeof formSchema>) => {
        try {

            const userMessage: OpenAI.Chat.CreateChatCompletionRequestMessage = {
                role: "user",
                content: values.prompt
            };


            const newMessages = [...messages, userMessage];

            const response = await axios.post("/api/conversation", {
                messages: newMessages
            });

            const reply = response.data;

            console.dir(reply);

            setRespuesta(reply.choices[0].message.content);

            //form.reset();

        } catch(error) {
            // TODO: Open Pro Modal
            console.log(error);
        } finally {
            router.refresh();
        }
    }

    return (
        <>
            <div>
                <Heading
                    title="Conversacion"
                    description="Modelo de Conversacion avanzado"
                    icon={MessageSquare}
                    iconColor="text-violet-500"
                    bgColor="bg-violet-500/10"
                />
                <div className="px-4 lg:px-8">
                    <Form {...form}>
                        <form
                            onSubmit={form.handleSubmit(onSubmit)}
                            className="
                                rounded-lg
                                border
                                w-full
                                p-4
                                px-3
                                md:px-6
                                focus-within:shadow-sm
                                grid
                                grid-cols-12
                                gap-2
                            "
                        >
                            <FormField
                                name="prompt"
                                render={({field})=>(
                                    <FormItem className="col-span-12 lg:col-span-10">
                                        <FormControl className="m-0 p-0">
                                            <Input
                                            className="border-0 outline-none
                                            focus-visible:ring-0
                                            focus-visible:ring-transparent"
                                            disabled={isLoading}
                                            placeholder="Cual es el mejor equipo de Chile?"
                                            {...field}
                                            />
                                        </FormControl>
                                    </FormItem>
                                )}
                            />
                            <Button className="col-span-12 lg:col-span-2 w-full"
                            disabled={isLoading}>
                                Preguntar a la IA
                            </Button>
                        </form>
                    </Form>
                </div>
                <div className="space-y-4 mt-4">
                    { isLoading && (
                        <div className="p-8 rounded-lg w-full flex items-center justify-center bg-muted">
                            <Loader />
                        </div>
                    )}
                    {respuesta.length===0 && !isLoading && (
                        <Empty
                            label="Esperando su pregunta..."
                        />
                    )}
                    { !isLoading && respuesta.length>0 && (
                        <div className="flex flex-col-reverse gap-y-4">
                            {respuesta}
                        </div>
                    )}
                </div>
            </div>
        </>
    )
}

export default ConversationPage;