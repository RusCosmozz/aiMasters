import React, {useEffect, useState} from 'react';
import {useParams} from "react-router-dom";
import World from "./World";
import Chat from "./Chat";

interface LobbyRouteParams {
    lobbyId: string;
}

const Lobby: React.FC = () => {
    const { lobbyId } = useParams<LobbyRouteParams>();
    const [requestWorldGeneration, setRequestWorldGeneration] =  useState(false);
    const [worldName, setWorldName] = useState<string | null>(null);
    const [worldDescription, setWorldDescription] = useState<string | null>(null);
    const [readyToGenerateWorld, setReadyToGenerateWorld] = useState(false);
    const [worldGenerated, setWorldGenerated] = useState(false);

    useEffect(() => {
        const fetchWorldData = async (gameId: string | undefined) => {
            try {
                const response = await fetch(`http://localhost:8086/api/game-sessions/${gameId}/worlds`);
                if (!response.ok) {
                    throw new Error('Failed to fetch world data');
                }

                const worldData = await response.json();
                setWorldName(worldData.worldName);
                setWorldDescription(worldData.worldDescription);
            } catch (error) {
                console.error('Error fetching world data:', error);
            }
        };

        if (lobbyId) {
            fetchWorldData(lobbyId);
        }
    }, [lobbyId]);

    return (
        <div>
            <div>
                <h1>Lobby</h1>
                <World
                    lobbyId={lobbyId}
                    onGenerateWorldClick={()=>{
                        setRequestWorldGeneration(true)
                    }}
                    onReadyToGenerateWorld={readyToGenerateWorld}
                    worldName={worldName}
                    worldDescription={worldDescription}
                    worldGenerated={worldGenerated}
                />
            </div>
            <Chat
                lobbyId={lobbyId}
                onReadyForWorldGeneration={() => {
                    setReadyToGenerateWorld(true);
                }}
                onWorldGenerationRequest={requestWorldGeneration}
                onWorldGenerated={(worldName, worldDescription) => {
                    setWorldName(worldName);
                    setWorldDescription(worldDescription);
                    setWorldGenerated(true);
                }}
            />
        </div>
    );
};

export default Lobby;