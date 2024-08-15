import React from "react";
import { useLocation } from "react-router-dom";
import "./header.css";

function BackHeader()
{
    let location = useLocation();
    let curPath = "";
    switch(location.pathname)
    {
        case "/portfolio":
            curPath = "Portfolio"
            break;
        case "/resume":
            curPath = "Resume";
            break;
        case "/joegpt":
            curPath = "JoeGPT";
            break;
        case "/contact":
            curPath = "Contact";
            break;
    }
    return (
        <header className="backHeader">
            <h1 className="header">{curPath}</h1>
            <a href="/">Home</a>
        </header>
    );
}

export default BackHeader;