Introduction of modules
	In this project we are focusing on mainly three modules:
			1.Sign to text or speech conversion.
			2.Text or speech to sign conversion.
			3.Insert sign.
(1)Sign to text or speech conversion:
		this module convert sign used by deaf and dumb people to communicate into the text
	or speech.For that we use kinect device that recognize body tracking of the user.but the problem is that this device track only point of palm so we will develop a algorithm to detect finger of the user and we name it ISLActionDetect(). this algorithm gives the position of the hand coordinates. now this coordinate is compared to action already stored and from this action we are able to identify word. by the sequence of such action every action is converted into word. we use this words to generate sentence and display it on the screen in Hindi language. So it will be easy to understand to the people who don't know English. And Hindi is our national language so there are more number of people who understand Hindi. We will Convert this sentence into speech.
	     this module helps to make conversation easy between deaf and dumb people and other people.
(2)Text or speech to sign conversation:
		this module is used to convert speech or text to action that can help full to deaf and dumb people to understand other people's speech. in this module first we recognize speech of other people and create a sentence of this speech. from this sentence we divides it in to the tokens and find verb and noun and find word. this word is used to compare with the already stored action and find action related to that word. we use avatar to perform action. the action matched with word is performed by avatar and deaf and dumb people can see it and understand the meaning of sentence.       		
(3)Insert Sign:
	This module is used to store sign that will later compare with the user action.User who wants to insert sign has to first insert name of the action in the text box and stand infront of the kinect and when USER says start. then the countdown of 3 has start at the finish of the count down user has to perform action. and this action is recorded for the later use. at the end of action user have to say finish and the action will recorded with the given name.