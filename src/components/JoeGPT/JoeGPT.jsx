import React, { useEffect, useState } from "react";
import BackHeader from "../header/BackHeader";
import api from "./axiosConfig";
import "./joeGPT.css";

function JoeGPT() {
    const [result, setResult] = useState("...");
    const [userInput, setUserInput] = useState("");

    async function setInitialVal()
    {
        const response = await api.get("/api/post");
        setResult(response.data);
    }

    useEffect(() => {
        setInitialVal();
    }, []);

    const handleText = (event) => {
        setUserInput(event.target.value);
    }

    const getServerResponse = async () => {    
        setResult("...");
        
        var curInput = "What kind of questions can I ask you about Joe Moser?";
        if(userInput !== "") curInput = userInput;
        console.log("User input:", curInput);
        setUserInput("");

        try
        {
            await api.post("/api/post", {input: curInput}).then(response => {
                console.log("Response:", response.data);
                setResult(response.data);
            });
        }
        catch(err)
        {
            setResult("Whoops, looks like something went wrong!");
            console.error(err);
        }
    }

    const checkEnter = (event) => {
        if(event.key === "Enter")
        {
            console.log("Enter");
            getServerResponse();
        }
    }

    return (
        <>
            <div>
                <BackHeader />
                <div className="monitor">
                    <div className="bezel">
                            <div className="monitorTextDiv"><p className="monitorText" >{result}</p></div>
                        <div className="textboxDiv">
                            <p className="textboxText">Type your question below:</p>
                            <input className="textbox" type="text" value={userInput} onChange={handleText} onKeyDown={checkEnter} />
                            <button className="enterButton" onClick={getServerResponse}>ENTER</button>
                        </div>
                    </div>
                    <div className="belowMonitor">
                        <div className="disk">
                            <div className="innerDisk" />
                        </div>
                        <h3 className="joeGPT">JoeGPT</h3>
                    </div>
                </div>
            </div>
        </>
    )
}

export default JoeGPT;