import React from "react";
import BackHeader from "../header/BackHeader";
import usa from "./usaCropped.jpg";
import "./contact.css";

function Contact() {
    return (
        <>
            <div>
                <BackHeader />
                <div className="businessCard">
                    <img src={usa} className="picture" />
                    <span></span>
                    <div className="contactInfo">
                        <h2>Joe Moser</h2>
                        <div className="websiteInfo">
                            <p className="websiteHeader">WEBSITE:</p>
                            <a href="/" className="websiteAnchor">joemoser.dev</a>
                        </div>
                        <div className="emailInfo">
                            <p className="emailHeader">EMAIL:</p>
                            <a href="mailto:joe@joemoser.dev" className="emailAnchor">joe@joemoser.dev</a>
                        </div>
                        <div className="phoneNumber">
                            <p className="phoneHeader">PHONE:</p>
                            <a href="tel:+14845536756" className="phoneAnchor">(484) 553-6756</a>
                        </div>
                    </div>
                    <span></span><span></span>
                </div>
                <div className="instructions">
                    <p className="instructionText">Click on a method of contact on my business card</p>
                </div>
            </div>
        </>
    )
}

export default Contact;