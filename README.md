# DnD-Screen

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Acknowledgements](#acknowledgements)

## Introduction
- This project is intended to display a DM-screen for Dungeon Masters to quickly keep track of monster stat blocks and turn orders.
- If you are anything like me you might find it difficult to keep track of all the information behind a dm-screen.
- You might find yourself with multiple tabs open that all display information and you have to quickly switch between them all while quickly
  jotting down notes on enemy health.
- The goal is that this app should compile all of these things into one place, as an open source alternative to DND Beyond that still emphasizes the flexibility
  that comes with pen and paper.
## Features
- Features include an initiative tracker, a character sheet editor.
- Features in progress: optional use of D&D 5e API (https://www.dnd5eapi.co/) to quickly build character sheets
- SQLlite storage solution for keeping track of existing character data.

## Installation
- Prerequisites Java JDK 21 (untested with earlier development kits)
- Maven 3.9.9
- Other dependencies are found in the pom.xml file 

## Usage
- This project is still a work in progress. And thus there isn't yet a clean wait to run the build.
- Running the main function in App.java and changing the set_scene from "initiativePage", to "edit" allows switching between different pages.

## Acknowledgements
- Thank you to my roommates, my wonderful players and my brother for many of the ideas for this project.
