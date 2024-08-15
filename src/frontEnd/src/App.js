import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Box, TextField, Typography, List, ListItem, ListItemText, CircularProgress, Grid } from '@mui/material';
import './App.css';
import foodImage from './mainpageimage.jpg';

function App() {
    const [question, setQuestion] = useState("");
    const [conversation, setConversation] = useState([
        { role: "assistant", content: "Hi there! What would you like to eat today? Here are some yummy categories to choose from:" }
    ]);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState("");

    const [topics] = useState([
        "Appetizers",
        "Main Courses",
        "Desserts",
        "Beverages",
        "Salads",
        "Soups"
    ]);

    const [conversationStarted, setConversationStarted] = useState(false);

    const [selectedTopic, setSelectedTopic] = useState("");

    // Predefined Q&A data
    const recipeQA = {
        "I am looking for a hearty vegan dinner option for tonight. What do you recommend?": `
Tofu Stir-Fry with Vegetables

Ingredients:
- Tofu (200g, firm, cubed)
- Olive oil (2 tablespoons)
- Broccoli (1 cup, florets)
- Bell pepper (1, sliced)
- Carrot (1, julienned)
- Soy sauce (2 tablespoons)
- Garlic (2 cloves, minced)
- Ginger (1 tablespoon, grated)
- Sesame seeds (1 teaspoon)

Instructions:
1. Press tofu to remove excess moisture, then cube.
2. Heat olive oil in a large pan over medium heat.
3. Add garlic and ginger, sauté for 1 minute.
4. Add broccoli, bell pepper, and carrot, cook for 5 minutes.
5. Add tofu and soy sauce, stir well to combine.
6. Cook for another 5-7 minutes until vegetables are tender and tofu is golden.
7. Garnish with sesame seeds before serving.
`,

        "I have a nut allergy and I'm looking for a healthy lunch option that doesn't include any nuts. Can you help?": `
Grilled Chicken Salad

Ingredients:
- Chicken breast (200g, grilled and sliced)
- Mixed greens (2 cups)
- Cherry tomatoes (1/2 cup, halved)
- Cucumber (1/2, sliced)
- Olive oil (2 tablespoons)
- Lemon juice (1 tablespoon)
- Salt and pepper to taste

Instructions:
1. Grill chicken breast until fully cooked, then slice.
2. In a large bowl, combine mixed greens, cherry tomatoes, and cucumber.
3. In a small bowl, whisk together olive oil, lemon juice, salt, and pepper.
4. Pour the dressing over the salad and toss to coat evenly.
5. Top the salad with sliced grilled chicken.
6. Serve fresh.
`,

        "It's getting cold outside, and I'm looking for a warm and comforting dinner recipe. What do you suggest?": `
Beef and Vegetable Stew

Ingredients:
- Beef chunks (500g)
- Potatoes (2, cubed)
- Carrots (2, sliced)
- Onion (1, chopped)
- Beef broth (4 cups)
- Tomato paste (1 tablespoon)
- Thyme (1 teaspoon, dried)
- Salt and pepper to taste

Instructions:
1. In a large pot, brown the beef chunks on all sides.
2. Add chopped onions and sauté until translucent.
3. Add potatoes and carrots to the pot.
4. Pour in beef broth and stir in tomato paste.
5. Season with thyme, salt, and pepper.
6. Bring to a boil, then reduce heat and simmer for about 1 hour until beef is tender and vegetables are cooked.
7. Serve hot, perfect for chilly evenings.
`
    };


    useEffect(() => {
        const savedConversation = localStorage.getItem('conversation');
        if (savedConversation) {
            setConversation(JSON.parse(savedConversation));
        }
    }, []);

    useEffect(() => {
        localStorage.setItem('conversation', JSON.stringify(conversation));
    }, [conversation]);

    const askQuestion = async () => {
        setLoading(true);
        setError("");
        const newConversation = [...conversation, { role: "user", content: question }];
        setConversation(newConversation);

        setConversationStarted(true);

        // Delay response to simulate network or processing delay
        setTimeout(() => {
            const assistantResponse = recipeQA[question] || "Sorry, I could not find an answer to your question.";
            setConversation(prev => [...prev, { role: "assistant", content: assistantResponse }]);
            setLoading(false);
            setQuestion(""); // Clear input field after asking
        }, 3500); // Delay of 2000 milliseconds (2 seconds)
    };


    const handleTopicSelect = (topic) => {
        setSelectedTopic(topic);
        const responseMessage = `You have selected ${topic}. Looking for delicious recipes...`;
        setConversation([...conversation, { role: "assistant", content: responseMessage }]);
    };

    return (
        <div className="App app-wrap-container">
            <div className="app-top-parts">
                <div style={{display: 'flex', justifyContent: 'center', alignItems: 'center'}}>
                    <img src={foodImage} alt="Delicious food" style={{width: '2rem', marginRight: '10px', height: '2rem', borderRadius: '50%'}}/>
                    <Typography variant="h4" gutterBottom>
                        FoodieBot
                    </Typography>
                </div>
                <List className="showing-list-wrap">
                    {conversation.map((entry, index) => (
                        <ListItem key={index} className={entry.role === "user" ? "user-message" : "assistant-message"}>
                            <ListItemText primary={entry.content} />
                        </ListItem>
                    ))}
                </List>
            </div>
            <div className="app-bottom-parts">
                {selectedTopic === "" && (
                    <Grid container spacing={2} className="topics-grid">
                        {!conversationStarted && (topics.map((topic, index) => (
                            <Grid item xs={10} sm={5} key={index}>
                                <div className="topic-buttons" onClick={() => handleTopicSelect(topic)}>
                                    {topic}
                                </div>
                            </Grid>
                        )))}
                    </Grid>
                )}
                <Box display="flex" alignItems="center" mt={2} className="input-box">
                    <TextField
                        className="input-box-body"
                        label="Ask a question..."
                        variant="outlined"
                        value={question}
                        onChange={(e) => setQuestion(e.target.value)}
                        disabled={loading}
                    />
                    <div
                        className="input-submit-button"
                        onClick={askQuestion}
                        style={{ marginLeft: '16px' }}
                    >
                        {loading ? <CircularProgress size={24} /> : "Ask"}
                    </div>
                </Box>
                {error && <Typography color="error" style={{ marginTop: '16px' }}>{error}</Typography>}
            </div>
        </div>
    );
}

export default App;

Can you recommend a quick vegetarian breakfast?
What's a good recipe for a gluten-free dinner?
I need a recipe for a classic cocktail for my home party.
