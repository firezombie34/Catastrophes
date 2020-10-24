const discord = require('discord.js')
const client = new discord.Client()
const {prefix, token} = require('./configs/config.json')
const fs = require('fs')

client.login(token)

client.on('ready',() => {
     console.log(client.user.username + ' logged in')
})

client.commands = new discord.Collection()
const commandFiles = fs.readdirSync('./commands').filter(file => file.endsWith('.js'))

for (const file of commandFiles) {
    const command = require(`./commands/${file}`)
    client.commands.set(command.name, command)
}

client.on('message', message => {
    if (!message.content.startsWith(prefix) || message.author.bot) return
    
    const args = message.content.slice(prefix.length).trim().split(/ +/)
    const command = args.shift().toLowerCase()

    if(!client.commands.has(command)) return

    try {
        client.commands.get(command).execute(message, args)
    } catch (error) {
        console.error(error) 
        message.channel.send('`There Was A Problem Processing that command!`')
    }
})

//examples for later in calling things
// please remeber to call command files as a handler if you are going to split commands into other files
//+	client.commands.get('ping').execute(message, args);
