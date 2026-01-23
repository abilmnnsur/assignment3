
CREATE TABLE teams (
    team_id SERIAL PRIMARY KEY,
    name VARCHAR(80) NOT NULL UNIQUE,
    country VARCHAR(50),
    team_rating NUMERIC(6,2) NOT NULL DEFAULT 1000.00,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE players (
    player_id SERIAL PRIMARY KEY,
    team_id INT REFERENCES teams(team_id) ON DELETE SET NULL,
    nickname VARCHAR(50) NOT NULL UNIQUE,
    real_name VARCHAR(80),
    country VARCHAR(50),
    player_rating NUMERIC(5,2) NOT NULL DEFAULT 1.00,
    kills INT NOT NULL DEFAULT 0 CHECK (kills >= 0),
    deaths INT NOT NULL DEFAULT 0 CHECK (deaths >= 0),
    matches_played INT NOT NULL DEFAULT 0 CHECK (matches_played >= 0),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tournaments (
    tournament_id SERIAL PRIMARY KEY,
    name VARCHAR(120) NOT NULL UNIQUE,
    tier VARCHAR(20) NOT NULL DEFAULT 'S' CHECK (tier IN ('S','A','B','C')),
    location VARCHAR(80),
    start_date DATE,
    end_date DATE
);


CREATE TABLE matches (
    match_id SERIAL PRIMARY KEY,
    tournament_id INT REFERENCES tournaments(tournament_id) ON DELETE SET NULL,

    team1_id INT NOT NULL REFERENCES teams(team_id) ON DELETE RESTRICT,
    team2_id INT NOT NULL REFERENCES teams(team_id) ON DELETE RESTRICT,

    match_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    team1_score INT NOT NULL DEFAULT 0 CHECK (team1_score >= 0),
    team2_score INT NOT NULL DEFAULT 0 CHECK (team2_score >= 0),

    winner_team_id INT REFERENCES teams(team_id) ON DELETE SET NULL,

    CHECK (team1_id <> team2_id),
    CHECK (winner_team_id IS NULL OR winner_team_id IN (team1_id, team2_id))
);


CREATE TABLE articles (
    article_id SERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    type VARCHAR(20) NOT NULL CHECK (type IN ('CS2','ESPORTS','MATCH_REPORT')),

    
    related_team_id INT REFERENCES teams(team_id) ON DELETE SET NULL,
    related_match_id INT REFERENCES matches(match_id) ON DELETE SET NULL,

    author_name VARCHAR(80) NOT NULL,
    published_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,


    UNIQUE (title, published_at)
);


CREATE TABLE tags (
    tag_id SERIAL PRIMARY KEY,
    name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE article_tags (
    article_id INT NOT NULL REFERENCES articles(article_id) ON DELETE CASCADE,
    tag_id INT NOT NULL REFERENCES tags(tag_id) ON DELETE CASCADE,
    PRIMARY KEY (article_id, tag_id)
);


INSERT INTO teams (name, country, team_rating) VALUES
('Vitality', 'France', 1300.00),
('Furia', 'Brazil', 1205.00),
('Spirit', 'Russia', 1090.00),
('Mouz','Europe',1080.00),
('Falcons', 'Europe', 1100.00),
('NAVI', 'Europe', 900.00),
('FAZE CLAN','Europe',850.00);


INSERT INTO players (team_id, nickname, real_name, country, player_rating, kills, deaths, matches_played) VALUES
(1, 'ZywOo', 'Mathieu Herbaut', 'France', 1.36, 2500, 1900, 300),
(1, 'ropz', 'Robin Kool', 'Estonia', 1.15, 2100, 1750, 300),
(1, 'Apex', 'Dan Madesclaire ', 'France', 0.9, 1600, 1800, 300),
(1, 'Mezii', 'William Merriman', 'Great Britain', 1.09, 1800, 1750, 300),
(1, 'FlameZ', 'Shahar Shushan', 'Israel', 1.12, 2000, 1850, 300),
(2, 'Fallen', 'Gabriel Toledo', 'Brazil', 0.85, 1200, 1400, 290),
(2, 'yuurih', 'Yuri Santos', 'Brazil', 1.06, 2200, 2000, 290),
(2, 'KSCERATO', 'Kaike Cerato', 'Brazil', 1.26, 2500, 2100, 290),
(2, 'Molodoy', 'Danil Golubenko', 'Kazakhstan', 1.32, 3600, 2000, 200),
(2, 'YEkindar', 'Mareks Galinskis', 'Latvia', 1.16, 2600, 2100, 200),
(3, 'Donk', 'Danil Kryshkovets', 'Russia', 1.41, 5500, 3000, 295),
(3, 'sh1ro', 'Dmitry Sokolov', 'Russia', 1.35, 5200, 2000, 295),
(3, 'magixx', 'Boris Vorobeiv', 'Russia', 0.9, 1800, 1900, 295),
(3, 'zont1x', 'Miroslav Plakhotia', 'Ukraine', 1.12, 2000, 1800, 295),
(3, 'tn1R' , 'Andrey Tatarinovich', 'Belarus', 1.15, 2100, 1950, 295),
(4, 'Torzsi', 'Adam Torzsas', 'Hungary', 1.12, 2000, 1800, 295),
(4, 'Brollan', 'Ludvig Brollin', 'Sweden', 0.9, 1800, 1900, 295),
(4, 'Jimmphat', 'Jimi Salo', 'Finland', 1.08, 1600, 1500, 295),
(4, 'Spinx', 'Lotan Giladi', 'Israel', 1.15, 2100, 1950, 295),
(4, 'xERTION', 'Dorian Berman', 'Israel', 1.16, 1600, 1300, 295),
(5, 'mONESY', 'Ilya Osipov', 'Russia', 1.38, 3000, 2000, 310),
(5, 'kyousuke', 'Maxim Lukin','Russia', 1.26, 2900, 2500, 180),
(5, 'Niko', 'Nikola Kovac', 'Bosnia', 1.18, 2950, 2800, 310),
(5, 'Teses', 'Rene Madsen', 'Denmark', 1.05, 2800,2750, 310),
(5, 'kyxsan', 'Damjan Stoilkovski', 'Macedonia', 0.7, 2100, 2400, 310),
(6, 'makazze ', 'Drin Shaqiri', 'Kosovo', 1.08, 1600, 1500, 295),
(6, 'AleksiB', 'Aleksi Verolainen', 'Finland', 0.6, 1500, 2000, 295),
(6, 'B1t', 'Valeriy Vakhovski', 'Ukraine', 1.15, 2100, 1950, 295),
(6, 'wonderful', 'Ihor Zhdanov', 'Ukraine',1.08, 1500, 1400, 295),
(6, 'iM', 'Mihail Ivan ', 'Romania', 1.06, 2200, 2000, 295),
(7, 'Twistzz', 'Russel Van Dulken', 'Canada', 1.15, 2100, 1950, 295),
(7, 'Frozen', 'David Chernansky', 'Slovakia', 1.16, 1600, 1300, 295),
(7, 'jcobb', 'Jacub Petrizeszwki', 'Poland', 1.10, 2000, 1800, 295),
(7, 'karrigan', 'Finn Anderson', 'Denmark', 0.8, 1400, 1900, 295),
(7, 'broky', 'Helvijs Saukants', 'Latvia', 1.08, 1500, 1400, 295);




INSERT INTO tournaments (name, tier, location, start_date, end_date) VALUES
('IEM Katowice', 'S', 'Katowice, Poland', '2026-01-31', '2026-02-08'),
('IEM Cologne', 'S', 'Cologne, Germany', '2026-06-18', '2026-07-01'),
('Blast Rival Finals', 'A', 'Hong-Kong, China', '2026-09-01', '2026-01-08'),
('Blast World Finals', 'S', 'London, Great Britain', '2026-12-10', '2026-12-17'),
('PGL Astana', 'A-', 'Astana, Kazakhstan', '2026-05-07', '2026-07-17');



INSERT INTO matches (tournament_id, team1_id, team2_id, team1_score, team2_score, winner_team_id) VALUES
(6, 1, 2, 10, 13, 2),
(6, 3, 4, 13, 9, 3),
(7, 5, 6, 12, 16, 6),
(8, 1, 7, 8, 13, 7),
(10, 1, 5, 13, 10, 1),
(10, 5, 2, 8, 13, 2),
(8, 6, 7, 13, 10, 6),
(10, 5, 2, 8, 13, 2);

INSERT INTO tags (name) VALUES
('transfer'),
('results'),
('patch'),
('drama');

INSERT INTO articles (title, content, type, related_team_id, related_match_id, author_name) VALUES
('Furia win close game vs Vitality', 'Match was intense, clutch rounds decided the outcome...', 'MATCH_REPORT', 2, 9, 'MC Sailaubek'),
('CS2 patch changes economy', 'Valve adjusted economy balance and weapon prices...', 'CS2', NULL, NULL, 'Dana Kentai'),
('Rumor: roster changes coming', 'Falcons might swap players before next event...', 'ESPORTS', 5, NULL, 'Kabidolla Kanapia');

INSERT INTO article_tags (article_id, tag_id) VALUES
(4, 2), -- results
(5, 3), -- patch
(6, 1), -- transfer
(4, 4); -- drama

-- I added a weapons,maps and skins also inventory of each player so i hope i will get a 100 pls) 
CREATE TABLE IF NOT EXISTS weapons (
    weapon_id SERIAL PRIMARY KEY,
    weapon_name VARCHAR(60) NOT NULL UNIQUE,
    weapon_type VARCHAR(30) NOT NULL CHECK (weapon_type IN ('RIFLE','PISTOL','SMG','SHOTGUN','SNIPER','LMG','KNIFE','GLOVES'))
);

CREATE TABLE IF NOT EXISTS skins (
    skin_id SERIAL PRIMARY KEY,
    weapon_id INT NOT NULL REFERENCES weapons(weapon_id) ON DELETE CASCADE,
    skin_name VARCHAR(120) NOT NULL,
    rarity VARCHAR(20) NOT NULL CHECK (rarity IN ('COMMON','UNCOMMON','RARE','MYTHICAL','LEGENDARY','ANCIENT')),
    market_price NUMERIC(12,2) NOT NULL CHECK (market_price >= 0),
    UNIQUE (weapon_id, skin_name)
);

CREATE TABLE IF NOT EXISTS player_inventory (
    player_id INT NOT NULL REFERENCES players(player_id) ON DELETE CASCADE,
    skin_id INT NOT NULL REFERENCES skins(skin_id) ON DELETE CASCADE,
    quantity INT NOT NULL DEFAULT 1 CHECK (quantity > 0),
    acquired_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (player_id, skin_id)
);

CREATE INDEX IF NOT EXISTS idx_skins_weapon_id ON skins(weapon_id);
CREATE INDEX IF NOT EXISTS idx_inventory_player_id ON player_inventory(player_id);

CREATE TABLE IF NOT EXISTS maps (
    map_id SERIAL PRIMARY KEY,
    map_name VARCHAR(60) NOT NULL UNIQUE,
    is_active_pool BOOLEAN NOT NULL DEFAULT TRUE
);

ALTER TABLE matches
ADD COLUMN IF NOT EXISTS map_id INT REFERENCES maps(map_id) ON DELETE SET NULL;

INSERT INTO weapons (weapon_name, weapon_type) VALUES
('AK-47','RIFLE'),
('M4A1-S','RIFLE'),
('AWP','SNIPER'),
('Glock-18','PISTOL'),
('Desert Eagle','PISTOL')
ON CONFLICT (weapon_name) DO NOTHING;

INSERT INTO skins (weapon_id, skin_name, rarity, market_price)
SELECT w.weapon_id, s.skin_name, s.rarity, s.market_price
FROM weapons w
JOIN (VALUES
  ('AK-47','Redline','RARE', 45.50),
  ('AK-47','Fire Serpent','ANCIENT', 850.00),
  ('M4A1-S','Printstream','LEGENDARY', 220.00),
  ('AWP','Asiimov','LEGENDARY', 180.00),
  ('Glock-18','Fade','MYTHICAL', 95.00),
  ('Desert Eagle','Blaze','MYTHICAL', 320.00)
) AS s(weapon_name, skin_name, rarity, market_price)
ON w.weapon_name = s.weapon_name
ON CONFLICT (weapon_id, skin_name) DO NOTHING;

INSERT INTO maps (map_name, is_active_pool) VALUES
('Mirage', TRUE),
('Inferno', TRUE),
('Nuke', TRUE),
('Ancient', TRUE),
('Anubis', TRUE),
('Overpass', FALSE),
('Vertigo', FALSE)
ON CONFLICT (map_name) DO NOTHING;

UPDATE matches
SET map_id = (SELECT map_id FROM maps WHERE map_name='Mirage')
WHERE match_id = 1;

UPDATE matches
SET map_id = (SELECT map_id FROM maps WHERE map_name='Inferno')
WHERE match_id = 2;


INSERT INTO player_inventory (player_id, skin_id, quantity)
VALUES
(1, (SELECT skin_id FROM skins WHERE skin_name='Fire Serpent' LIMIT 1), 1),
(1, (SELECT skin_id FROM skins WHERE skin_name='Redline' LIMIT 1), 2),
(2, (SELECT skin_id FROM skins WHERE skin_name='Printstream' LIMIT 1), 1),
(3, (SELECT skin_id FROM skins WHERE skin_name='Asiimov' LIMIT 1), 1),
(3, (SELECT skin_id FROM skins WHERE skin_name='Fade' LIMIT 1), 1)
ON CONFLICT (player_id, skin_id) DO UPDATE SET quantity = EXCLUDED.quantity;

SELECT p.nickname,
       SUM(pi.quantity * s.market_price) AS total_value
FROM players p
JOIN player_inventory pi ON pi.player_id = p.player_id
JOIN skins s ON s.skin_id = pi.skin_id
WHERE p.player_id = 1
GROUP BY p.nickname;

SELECT p.nickname,
       SUM(pi.quantity * s.market_price) AS total_value
FROM players p
JOIN player_inventory pi ON pi.player_id = p.player_id
JOIN skins s ON s.skin_id = pi.skin_id
GROUP BY p.nickname
ORDER BY total_value DESC;

SELECT p.nickname, s.rarity, SUM(pi.quantity) AS count_items
FROM players p
JOIN player_inventory pi ON pi.player_id = p.player_id
JOIN skins s ON s.skin_id = pi.skin_id
WHERE p.player_id = 1
GROUP BY p.nickname, s.rarity
ORDER BY count_items DESC;

SELECT m.map_name, COUNT(*) AS matches_count
FROM matches ma
JOIN maps m ON m.map_id = ma.map_id
GROUP BY m.map_name
ORDER BY matches_count DESC;