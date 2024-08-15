import React from "react";
import "./header.css"

function MainHeader()
{
    return (
        <header className="homepageHeader">
            <h1 className="joemoserHeader">Joe Moser</h1>
            <nav>
                <a href="portfolio">Portfolio</a>
                <a href="resume">Resume</a>
                <a href="joegpt">JoeGPT</a>
                <a href="contact">Contact</a>
            </nav>
        </header>
    );
}

export default MainHeader;