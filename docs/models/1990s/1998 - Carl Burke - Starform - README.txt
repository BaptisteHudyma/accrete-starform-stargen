Introduction

This applet simulates the formation of planets by accretion from the protoplanetary disc. Protoplanets are injected into the disc at random locations and suck up dust (and gas, if they're large enough) until they can't grow any more. Planets which make it through accretion without becoming gas giants are then put through a number of environmental calculations to determine temperature, atmosphere, hydrosphere, and so on. While scientific thought has moved on in the 30 years since this algorithm was first developed by Stephen Dole, this algorithm has the advantage of being extremely fast on modern computers; current methods for simulating planet formation involve extremely complex n-body and fluid dynamics code running for long periods of time on supercomputers.

This is an alpha release of this code as an applet, although there have been several versions of the code (in Pascal, C, Modula-2, C++, and now Java) so most of the glitches should have been worked out. If you encounter any serious problems with this code, please let me know what problems you had. It might help me a lot to know your browser and system configuration in the event that you find bugs.

There are some known display glitches with some browsers:

    Internet Explorer 3.01 sometimes leaves white bars across the applet; these go away if you scroll around.

There are no known fatal bugs, or bugs which hang the browser.

This applet was built using SuperCede (Java Edition), and is compatible with JDK 1.0.2. The latest .class files were compiled with JDK version 1.1.6, so they might not be binary-compatible with an older browser. Sorry.

Description

The applet uses a lot of screen real estate, but we can divide it into four sections. The top section controls the construction process, showing the current random seed (in hexadecimal, or base 16) and the next random seed (in the text field). You can edit this value, if you wish; clicking 'Set seed' will use the value you specify instead of the randomly determined value. Clicking 'Make new star system' will do just that.

The second section describes the star and the planets. By clicking on the radio buttons along the top of the planet description panel, you can look at the characteristics of each of the planets in the system.

The third section shows the relative sizes of the planets, laid out in a row at the appropriate distance from the star. Distance from the star is scaled logarithmically, while the planet size is scaled linearly; this makes earthlike planets hard to see in this current release.

The fourth and last section shows the planets and their orbits as if you were looking down on the solar system from a very long way to the north. Well... as if you were looking from a very long way with eyes that logarithmically scaled both the distance from the sun and the planetary sizes.

The planetary images are just cropped and scaled images of planets and moons in our solar system; they shouldn't be taken as gospel, but are just meant to help you visualize your new solar system.

Future Enhancements

There are always more things I'd like to do with this applet, but some of the more pressing needs are:

    Clean up planet images, either with transparent GIFs or through an ImageFilter
    Clickable planet images in addition to the row of radio buttons
    Better and/or more controllable distribution of stellar classes
    Effects of gravitational resonances
    Better handling of brown dwarfs
    More sophisticated classification of planets
    More rational distribution of planets, probably concerning Dermot's Law
    Moons, distributed by Dermot's Law for gas giants and as a result of protoplanet collisions for terrestrials
    Text export

There are also some things which I will probably not handle in any detail:

    Multiple star systems
    Stars which aren't on the main sequence
    Comets, asteroids

I'd love to hear suggestions from users of this applet. Any features you'd like to see or corrections that you can provide will be graciously accepted.

Source Code

I've contacted Matt Burdick (the author of starform) to find out exactly what restrictions he put on his code. (To be more precise, his brother saw this page and made the introductions.) As far as he and I are concerned, this software is free for your use as long as you don't sell it. I take that to mean that you can include this code in a commercial package (like a game) without fee, as long as that package isn't just a prettier version of this applet. There's a longer copyright notice in the source files, but this gets the gist across.

The source code is in this Unix tarred & gzipped file, or in this Windows/DOS zip archive.
Acknowledgements

Matt Burdick, the author of 'starform' (freely redistributable); much of the code (particularly planetary environments) was adapted from his code.

Andrew Folkins, the author of 'accretion' (public domain) for the Amiga; I used chunks of his code when creating my displays.

Ed Taychert of Irony Games, for the algorithm he uses to classify terrestrial planets in his tabular CGI implementation of 'starform'.

Paul Schlyter, who provided information about computing planetary positions.

Planetary images courtesy Jet Propulsion Laboratory. Copyright (c) California Institute of Technology, Pasadena, CA. All rights reserved.
Bibliography

These sources are the ones quoted by Burdick in the code. A good web search (or more old-fashioned literature search) will identify literally hundreds of papers regarding the formation of the solar system and the evolution of proplyds (protoplanetary discs). Most of these sources can be difficult for a layman like myself to locate, but those journals are the best place to get up to speed on current theories of formation.

"Extra-Solar Planetary Systems: A Microcomputer Simulation", Martyn J. Fogg, Journal of the British Interplanetary Society Vol 38, pp. 501 - 514, 1985

"The Evolution of the Atmosphere of the Earth", Michael H. Hart, Icarus, Vol 33, pp. 23 - 39, 1978

"The Internal Constitution of the Planets", D. S. Kothari, Ph.D. , Mon. Not. Roy. Astr. Soc. Vol 96, pp. 833 - 843, 1936

"Formation of Planetary Systems by Aggregation: A Computer Simulation", S. H. Dole, RAND paper no. P-4226, 1969

"Habitable Planets for Man", S. H. Dole, Blaisdell Publishing Company, NY, 1964.

"Q in the Solar System", P. Goldreich and S. Soter, Icarus, Vol 5, pp. 375 - 389, 1966
Related Pages

If you know of any other pages related to Accrete or Starform, please tell me.

Accrete (several implementations, including Java executable)
StarForm at Irony Games (tabular output on web page)
USML Archives, now at GeoCities
